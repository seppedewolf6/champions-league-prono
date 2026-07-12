// components/dashboard/TeamFormation.tsx
import { useMemo } from "react";
import type { TeamPlayerResponse, PlayerPosition } from "../../types/team";

interface Props {
    players: TeamPlayerResponse[];
}

interface FormationRow {
    key: string;
    players: TeamPlayerResponse[];
}

/**
 * Verdeelt een totaal aantal veldspelers in 3 zo gelijk mogelijke rijen.
 * bv. 10 -> [4, 3, 3], 12 -> [4, 4, 4], 7 -> [3, 2, 2]
 * De rest (bij niet deelbaar door 3) gaat eerst naar de verdedigingsrij,
 * dan pas naar midden/aanval.
 */
function balancedThirds(total: number): [number, number, number] {

    const base = Math.floor(total / 3);
    const remainder = total - base * 3;

    const sizes: [number, number, number] = [base, base, base];

    for (let i = 0; i < remainder; i++) {
        sizes[i]++;
    }

    return sizes;
}

/**
 * Bouwt de 3 veldrijen (verdediging / midden / aanval) op:
 * elke rij krijgt eerst spelers van de "eigen" positie, en wordt pas
 * daarna aangevuld met overtollige spelers van andere posities.
 * Zo verdwijnt er nooit een speler uit beeld, ongeacht de verdeling
 * die de gebruiker koos (bv. 10 aanvallers is toegestaan).
 */
function buildOutfieldRows(
    players: TeamPlayerResponse[]
): { defense: TeamPlayerResponse[]; midfield: TeamPlayerResponse[]; attack: TeamPlayerResponse[] } {

    const pools: Record<Exclude<PlayerPosition, "KEEPER">, TeamPlayerResponse[]> = {
        DEFENDER: players.filter((p) => p.position === "DEFENDER"),
        MIDFIELDER: players.filter((p) => p.position === "MIDFIELDER"),
        ATTACKER: players.filter((p) => p.position === "ATTACKER"),
    };

    const total = pools.DEFENDER.length + pools.MIDFIELDER.length + pools.ATTACKER.length;
    const [defenseCap, midfieldCap, attackCap] = balancedThirds(total);

    const defense = pools.DEFENDER.splice(0, defenseCap);
    const midfield = pools.MIDFIELDER.splice(0, midfieldCap);
    const attack = pools.ATTACKER.splice(0, attackCap);

    // Overtollige spelers zitten nu nog in pools.* — verdeel die over
    // de rijen die hun capaciteit nog niet bereikt hebben.
    const leftoverOrder: (keyof typeof pools)[] = ["DEFENDER", "MIDFIELDER", "ATTACKER"];

    const fill = (row: TeamPlayerResponse[], capacity: number) => {
        while (row.length < capacity) {
            const source = leftoverOrder.find((key) => pools[key].length > 0);
            if (!source) break;
            row.push(pools[source].shift() as TeamPlayerResponse);
        }
    };

    fill(defense, defenseCap);
    fill(midfield, midfieldCap);
    fill(attack, attackCap);

    return { defense, midfield, attack };
}

export default function TeamFormation({ players }: Props) {

    const starters = players.filter((p) => p.isStarter);

    const rows: FormationRow[] = useMemo(() => {

        const keepers = starters.filter((p) => p.position === "KEEPER");
        const outfielders = starters.filter((p) => p.position !== "KEEPER");

        const { defense, midfield, attack } = buildOutfieldRows(outfielders);

        return [
            { key: "attack", players: attack },
            { key: "midfield", players: midfield },
            { key: "defense", players: defense },
            { key: "keeper", players: keepers },
        ];

    }, [starters]);

    const hasAnyPlayers = starters.length > 0;

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

                    .formation__empty {
                        color: rgba(255, 255, 255, 0.55);
                        text-align: center;
                        font-size: 0.9rem;
                        padding: 1rem 0;
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

            {!hasAnyPlayers && (
                <p className="formation__empty">Nog geen spelers opgesteld.</p>
            )}

            {hasAnyPlayers && rows.map((row) => {

                if (row.players.length === 0) return null;

                return (
                    <div className="formation__row" key={row.key}>
                        {row.players.map((player) => (
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