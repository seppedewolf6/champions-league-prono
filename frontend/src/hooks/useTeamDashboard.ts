// hooks/useTeamDashboard.ts
import { useCallback, useEffect, useState } from "react";
import { getMyTeam, getMyScore, getMyRanking } from "../api/teamApi";
import type {
    TeamResponse,
    TeamScoreResponse,
    MyRankingResponse
} from "../types/team";

interface DashboardState {
    loading: boolean;
    team: TeamResponse | null;
    score: TeamScoreResponse | null;
    ranking: MyRankingResponse | null;
    error: string | null;
}

export function useTeamDashboard() {

    const [state, setState] = useState<DashboardState>({
        loading: true,
        team: null,
        score: null,
        ranking: null,
        error: null,
    });

    const load = useCallback(async () => {

        setState((prev) => ({ ...prev, loading: true, error: null }));

        let team: TeamResponse | null;

        try {
            team = await getMyTeam();
        } catch {
            setState({
                loading: false,
                team: null,
                score: null,
                ranking: null,
                error: "Er ging iets mis bij het ophalen van je dashboard.",
            });
            return;
        }

        if (!team) {
            setState({
                loading: false,
                team: null,
                score: null,
                ranking: null,
                error: null,
            });
            return;
        }

        // Score en ranking onafhankelijk van elkaar ophalen: als een van
        // beide (nog) niet bestaat op de backend, mag dat de rest van het
        // dashboard niet blokkeren.
        const [scoreResult, rankingResult] = await Promise.allSettled([
            getMyScore(),
            getMyRanking(),
        ]);

        setState({
            loading: false,
            team,
            score: scoreResult.status === "fulfilled" ? scoreResult.value : null,
            ranking: rankingResult.status === "fulfilled" ? rankingResult.value : null,
            error: null,
        });

    }, []);

    useEffect(() => {
        load();
    }, [load]);

    return { ...state, reload: load };
}