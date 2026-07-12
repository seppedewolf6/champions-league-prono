// components/dashboard/TeamFormation.tsx
import type { TeamPlayerResponse, PlayerPosition } from "../../types/team";

interface Props {
    players: TeamPlayerResponse[];
}

const POSITION_ORDER: PlayerPosition[] = ["ATTACKER", "MIDFIELDER", "DEFENDER", "KEEPER"];

export default function TeamFormation({ players }: Props) {

    const starters = players.filter((p) => p.isStarter);

    return (
        <div className="formation">

            <style>
                {`
                    .formation {
                        width: 100%;
                        border-radius: 20px;
                        padding: 1.5rem 1rem 2rem;
                        background:
                            repeating-linear-gradient(
                                0deg,
                                rgba(255, 255, 255, 0.03) 0px,
                                rgba(255, 255, 255, 0.03) 40px,
                                transparent 40px,
                                transparent 80px
                            ),
                            linear-gradient(180deg, #0f5c33 0%, #0b4326 100%);
                        border: 1px solid rgba(255, 255, 255, 0.08);
                        display: flex;
                        flex-direction: column;
                        gap: 1.75rem;
                    }

                    .formation__row {
                        display: flex;
                        justify-content: center;
                        flex-wrap: wrap;
                        gap: 1.25rem;
                    }

                    .formation__player {
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        width: 84px;
                        text-align: center;
                    }

                    .formation__badge {
                        width: 44px;
                        height: 44px;
                        border-radius: 50%;
                        background: linear-gradient(135deg, #00d4ff, #a21caf);
                        color: #ffffff;
                        font-weight: 800;
                        font-size: 0.85rem;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        box-shadow: 0 8px 18px rgba(0, 0, 0, 0.35);
                        margin-bottom: 0.4rem;
                    }

                    .formation__name {
                        color: #ffffff;
                        font-size: 0.78rem;
                        font-weight: 700;
                        line-height: 1.2;
                    }

                    .formation__club {
                        color: rgba(255, 255, 255, 0.55);
                        font-size: 0.68rem;
                        margin-top: 0.15rem;
                    }

                    @media (max-width: 480px) {
                        .formation__player {
                            width: 68px;
                        }

                        .formation__badge {
                            width: 36px;
                            height: 36px;
                            font-size: 0.7rem;
                        }

                        .formation__name {
                            font-size: 0.68rem;
                        }
                    }
                `}
            </style>

            {POSITION_ORDER.map((position) => {

                const rowPlayers = starters.filter((p) => p.position === position);

                if (rowPlayers.length === 0) return null;

                return (
                    <div className="formation__row" key={position}>
                        {rowPlayers.map((player) => (
                            <div className="formation__player" key={player.id}>
                                <div className="formation__badge">
                                    {getInitials(player.playerName)}
                                </div>
                                <span className="formation__name">{player.playerName}</span>
                                <span className="formation__club">{player.clubName}</span>
                            </div>
                        ))}
                    </div>
                );
            })}

        </div>
    );
}

function getInitials(name: string): string {
    return name
        .split(" ")
        .map((part) => part[0])
        .join("")
        .slice(0, 2)
        .toUpperCase();
}