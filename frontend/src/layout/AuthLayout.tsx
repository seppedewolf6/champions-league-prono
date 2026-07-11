// AuthLayout.tsx
import { Outlet } from "react-router-dom";
import computerBackground from "../assets/images/loginComputerBackground.jpg";
import phoneBackground from "../assets/images/loginPhoneBackground.jpg";

export default function AuthLayout() {
    return (
        <main className="auth-shell">

            <style>
                {`
                    .auth-shell {
                        box-sizing: border-box;
                        min-height: 100dvh;
                        width: 100%;
                        position: relative;
                        background-color: #050b1a;
                        background-image: url(${computerBackground});
                        background-size: cover;
                        background-position: center;
                        background-repeat: no-repeat;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        padding: 2rem 1.5rem;
                        overflow: hidden;
                    }

                    .auth-shell::before {
                        content: "";
                        position: absolute;
                        inset: 0;
                        background: linear-gradient(
                            180deg,
                            rgba(5, 11, 26, 0.55) 0%,
                            rgba(5, 11, 26, 0.35) 35%,
                            rgba(5, 11, 26, 0.75) 100%
                        );
                        z-index: 1;
                    }

                    .auth-shell__content {
                        position: relative;
                        z-index: 2;
                        width: 100%;
                        display: flex;
                        justify-content: center;
                    }

                    @media (max-width: 900px) {
                        .auth-shell {
                            background-image: url(${phoneBackground});
                            background-size: cover;
                            background-position: top center;
                        }
                    }
                `}
            </style>

            <div className="auth-shell__content">
                <Outlet />
            </div>

        </main>
    );
}