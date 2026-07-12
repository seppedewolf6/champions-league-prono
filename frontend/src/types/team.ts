// types/team.ts
export type PlayerPosition = "KEEPER" | "DEFENDER" | "MIDFIELDER" | "ATTACKER";

export interface TeamPlayerResponse {
    id: string;
    playerId: string;
    playerName: string;
    clubName: string;
    position: PlayerPosition;
    isStarter: boolean;
    totalPoints: number;
}

export interface TeamResponse {
    id: string;
    teamName: string;
    locked: boolean;
    players: TeamPlayerResponse[];
}

export interface TeamScoreResponse {
    totalScore: number;
}

export interface MyRankingResponse {
    rank: number;
    totalScore: number;
    totalParticipants: number;
}