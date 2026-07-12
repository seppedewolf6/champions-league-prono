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

        try {

            const team = await getMyTeam();

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

            const [score, ranking] = await Promise.all([
                getMyScore(),
                getMyRanking(),
            ]);

            setState({ loading: false, team, score, ranking, error: null });

        } catch {

            setState({
                loading: false,
                team: null,
                score: null,
                ranking: null,
                error: "Er ging iets mis bij het ophalen van je dashboard.",
            });

        }

    }, []);

    useEffect(() => {
        load();
    }, [load]);

    return { ...state, reload: load };
}