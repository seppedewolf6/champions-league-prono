// api/teamApi.ts
import axios from "axios";
import api from "./axios";
import type {
    TeamResponse,
    TeamScoreResponse,
    MyRankingResponse
} from "../types/team";

/**
 * Haalt het team van de ingelogde gebruiker op.
 * Geeft null terug als er nog geen team bestaat (404).
 */
export const getMyTeam = async (): Promise<TeamResponse | null> => {

    try {
        const response = await api.get<TeamResponse>("/teams/me");
        return response.data;

    } catch (error) {

        if (axios.isAxiosError(error) && error.response?.status === 404) {
            return null;
        }

        throw error;
    }
};

export const getMyScore = async (): Promise<TeamScoreResponse> => {
    const response = await api.get<TeamScoreResponse>("/teams/me/score");
    return response.data;
};

export const getMyRanking = async (): Promise<MyRankingResponse> => {
    const response = await api.get<MyRankingResponse>("/ranking/me");
    return response.data;
};