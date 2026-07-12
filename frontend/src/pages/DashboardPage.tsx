// pages/DashboardPage.tsx
import { useNavigate } from "react-router-dom";
import { useAuth } from "../hooks/useAuth";
import { useTeamDashboard } from "../hooks/useTeamDashboard";
import TeamFormation from "../components/dashboard/TeamFormation";
import StatCard from "../components/dashboard/StatCard";

const stateStyles = `
    .dashboard-state {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        gap: 1.25rem;
        padding: 4rem 1.5rem;
        text-align: center;
        color: rgba(255, 255, 255, 0.75);
    }

    .dashboard-state__button {
        background: linear-gradient(90deg, #0099cc 0%, #00d4ff 35%, #a21caf 100%);
        border: none;
        color: #ffffff;
        font-weight: 700;
        font-size: 0.95rem;
        padding: 0.85rem 1.75rem;
        border-radius: 12px;
        cursor: pointer;
        box-shadow: 0 10px 30px rgba(0, 212, 255, 0.25);
    }
`;

export default function DashboardPage() {

    const { user } = useAuth();
    const navigate = useNavigate();
    const { loading, team, score, ranking, error, reload } = useTeamDashboard();

    if (loading) {
        return (
            <div className="dashboard-state">
                <style>{stateStyles}</style>
                <p>Dashboard wordt geladen...</p>
            </div>
        );
    }

    if (error) {
        return (
            <div className="dashboard-state">
                <style>{stateStyles}</style>
                <p>{error}</p>
                <button onClick={reload} className="dashboard-state__button">
                    Opnieuw proberen
                </button>
            </div>
        );
    }

    if (!team) {
        return (
            <div className="dashboard-state">
                <style>{stateStyles}</style>
                <p>Welkom {user?.username}, je hebt nog geen team gemaakt.</p>
                <button
                    onClick={() => navigate("/mijn-team")}
                    className="dashboard-state__button"
                >
                    Maak nu je team
                </button>
            </div>
        );
    }

    return (
        <div className="dashboard-page">

            <style>
                {`
                    .dashboard-page {
                        display: flex;
                        flex-direction: column;
                        gap: 1.75rem;
                    }

                    .dashboard-page__title {
                        color: #ffffff;
                        font-size: 1.9rem;
                        font-weight: 800;
                        text-align: center;
                        margin: 0;
                    }

                    .dashboard-page__edit-button {
                        align-self: center;
                        background: rgba(255, 255, 255, 0.05);
                        border: 1px solid rgba(255, 255, 255, 0.12);
                        color: #ffffff;
                        font-weight: 700;
                        font-size: 0.88rem;
                        padding: 0.7rem 1.4rem;
                        border-radius: 12px;
                        cursor: pointer;
                        transition: border-color 0.2s ease, background 0.2s ease;
                    }

                    .dashboard-page__edit-button:hover {
                        background: rgba(255, 255, 255, 0.1);
                        border-color: #00d4ff;
                    }

                    .dashboard-page__stats {
                        display: flex;
                        gap: 1.25rem;
                        flex-wrap: wrap;
                    }
                `}
            </style>

            <h1 className="dashboard-page__title">{team.teamName}</h1>

            <TeamFormation players={team.players} />

            <button
                onClick={() => navigate("/mijn-team")}
                className="dashboard-page__edit-button"
            >
                Team aanpassen
            </button>

            <div className="dashboard-page__stats">
                <StatCard
                    label="Totale score"
                    value={score ? String(Math.round(score.totalScore)) : "-"}
                />

                <StatCard
                    label="Jouw plaats in de ranking:"
                    value={ranking ? `#${ranking.rank}` : "-"}
                />
            </div>

        </div>
    );
}