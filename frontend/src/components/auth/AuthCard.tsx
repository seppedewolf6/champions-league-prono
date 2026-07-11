//AuthCard.tsx

interface Props {
    children: React.ReactNode;
    title: string;
    subtitle?: string;
}

export default function AuthCard({
                                     children,
                                     title,
                                     subtitle
                                 }: Props) {
    return (
        <div className="auth-card">

            <style>
                {`
                    .auth-card {
                        width: 100%;
                        max-width: 420px;
                        background: rgba(10, 18, 36, 0.72);
                        backdrop-filter: blur(20px);
                        border: 1px solid rgba(255, 255, 255, 0.08);
                        border-radius: 20px;
                        padding: 2.75rem 2.25rem;
                        position: relative;
                        box-shadow:
                            0 24px 60px rgba(0, 0, 0, 0.45),
                            0 0 0 1px rgba(255, 255, 255, 0.02) inset;
                    }

                    .auth-card::before {
                        content: "";
                        position: absolute;
                        top: 0;
                        left: 2.25rem;
                        right: 2.25rem;
                        height: 2px;
                        background: linear-gradient(
                            90deg,
                            transparent,
                            #00d4ff 30%,
                            #c026d3 70%,
                            transparent
                        );
                        border-radius: 2px;
                    }

                    .auth-card__eyebrow {
                        font-family: -apple-system, "Segoe UI", sans-serif;
                        font-size: 0.7rem;
                        font-weight: 700;
                        letter-spacing: 0.28em;
                        text-transform: uppercase;
                        color: #00d4ff;
                        margin: 0 0 0.85rem;
                    }

                    .auth-card__title {
                        font-family: "Arial Narrow", "Helvetica Neue", sans-serif;
                        font-weight: 800;
                        font-size: 2.1rem;
                        letter-spacing: 0.01em;
                        color: #ffffff;
                        margin: 0;
                        line-height: 1.1;
                    }

                    .auth-card__subtitle {
                        color: rgba(255, 255, 255, 0.55);
                        font-size: 0.92rem;
                        margin: 0.6rem 0 0;
                        line-height: 1.5;
                    }

                    .auth-card__header {
                        margin-bottom: 2.25rem;
                    }
                    
                    .auth-switch {
                    color: rgba(255, 255, 255, 0.45);
                    text-align: center;
                    margin-top: 1.75rem;
                    font-size: 0.88rem;
                    }

                    .auth-switch__link {
                        background: none;
                        border: none;
                        cursor: pointer;
                        margin-left: 0.4rem;
                        font-size: 0.88rem;
                        font-weight: 700;
                        color: #00d4ff;
                        position: relative;
                        transition: color 0.2s ease;
                    }

                    .auth-switch__link::after {
                        content: "";
                        position: absolute;
                        left: 0;
                        bottom: -2px;
                        width: 100%;
                        height: 1px;
                        background: linear-gradient(90deg, #00d4ff, #c026d3);
                        transform: scaleX(0);
                        transform-origin: left;
                        transition: transform 0.25s ease;
                    }
                    
                    .auth-switch__link:hover {
                        color: #5ce1ff;
                    }
                    
                    .auth-switch__link:hover::after {
                        transform: scaleX(1);
                    }
                `}
            </style>

            <div className="auth-card__header">
                <p className="auth-card__eyebrow">Champions League Prono</p>
                <h1 className="auth-card__title">{title}</h1>

                {subtitle && (
                    <p className="auth-card__subtitle">{subtitle}</p>
                )}
            </div>

            {children}
        </div>
    );
}