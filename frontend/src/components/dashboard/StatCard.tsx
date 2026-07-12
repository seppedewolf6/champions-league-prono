// components/dashboard/StatCard.tsx
interface Props {
    label: string;
    value: string;
}

export default function StatCard({ label, value }: Props) {
    return (
        <div className="stat-card">

            <style>
                {`
                    .stat-card {
                        flex: 1;
                        min-width: 200px;
                        background: rgba(10, 18, 36, 0.72);
                        backdrop-filter: blur(20px);
                        border: 1px solid rgba(255, 255, 255, 0.08);
                        border-radius: 16px;
                        padding: 1.5rem;
                        text-align: center;
                    }

                    .stat-card__label {
                        color: rgba(255, 255, 255, 0.55);
                        font-size: 0.85rem;
                        margin: 0 0 0.5rem;
                    }

                    .stat-card__value {
                        color: #ffffff;
                        font-size: 2.1rem;
                        font-weight: 800;
                        margin: 0;
                    }
                `}
            </style>

            <p className="stat-card__label">{label}</p>
            <p className="stat-card__value">{value}</p>

        </div>
    );
}