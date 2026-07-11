// AuthInput.tsx

import { forwardRef } from "react";

interface Props extends React.InputHTMLAttributes<HTMLInputElement> {
    label: string;
}

const AuthInput = forwardRef<HTMLInputElement, Props>(
    ({ label, type = "text", placeholder, ...props }, ref) => {
        return (
            <div className="auth-input">

                <style>
                    {`
                        .auth-input {
                            display: flex;
                            flex-direction: column;
                            gap: 0.5rem;
                            margin-bottom: 1.4rem;
                        }

                        .auth-input__label {
                            font-size: 0.78rem;
                            font-weight: 600;
                            letter-spacing: 0.04em;
                            color: rgba(255, 255, 255, 0.65);
                        }

                        .auth-input__field {
                            background: rgba(255, 255, 255, 0.04);
                            color: #ffffff;
                            border-radius: 12px;
                            padding: 0.85rem 1rem;
                            border: 1px solid rgba(255, 255, 255, 0.12);
                            font-size: 0.95rem;
                            transition: border-color 0.2s ease, background 0.2s ease, box-shadow 0.2s ease;
                        }

                        .auth-input__field::placeholder {
                            color: rgba(255, 255, 255, 0.32);
                        }

                        .auth-input__field:focus {
                            outline: none;
                            background: rgba(255, 255, 255, 0.06);
                            border-color: transparent;
                            box-shadow:
                                0 0 0 1.5px #00d4ff,
                                0 0 22px rgba(0, 212, 255, 0.25);
                        }
                    `}
                </style>

                <label className="auth-input__label">{label}</label>

                <input
                    ref={ref}
                    type={type}
                    placeholder={placeholder}
                    className="auth-input__field"
                    {...props}
                />

            </div>
        );
    }
);

AuthInput.displayName = "AuthInput";

export default AuthInput;