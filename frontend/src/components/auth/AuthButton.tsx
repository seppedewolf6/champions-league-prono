// AuthButton.tsx

interface Props {
    children: React.ReactNode;
    loading?: boolean;
}

export default function AuthButton({
                                       children,
                                       loading = false
                                   }: Props) {
    return (
        <button
            disabled={loading}
            className="auth-button"
        >

            <style>
                {`
                    .auth-button {
                        width: 100%;
                        padding: 0.95rem;
                        border-radius: 12px;
                        border: none;
                        color: #ffffff;
                        font-weight: 700;
                        font-size: 0.95rem;
                        letter-spacing: 0.02em;
                        cursor: pointer;
                        background: linear-gradient(
                            90deg,
                            #0099cc 0%,
                            #00d4ff 35%,
                            #a21caf 100%
                        );
                        box-shadow: 0 10px 30px rgba(0, 212, 255, 0.25);
                        transition: transform 0.18s ease, box-shadow 0.18s ease, opacity 0.18s ease;
                    }

                    .auth-button:hover:not(:disabled) {
                        transform: translateY(-1px);
                        box-shadow: 0 14px 36px rgba(0, 212, 255, 0.38);
                    }

                    .auth-button:active:not(:disabled) {
                        transform: translateY(0);
                    }

                    .auth-button:disabled {
                        opacity: 0.55;
                        cursor: not-allowed;
                        transform: none;
                    }
                `}
            </style>

            {loading ? "Laden..." : children}
        </button>
    );
}