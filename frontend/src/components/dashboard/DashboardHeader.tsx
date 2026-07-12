// components/dashboard/DashboardHeader.tsx
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../../hooks/useAuth";
import logo from "../../assets/logo.png";
import NavBar from "./NavBar";

export default function DashboardHeader() {

    const navigate = useNavigate();
    const { logoutUser } = useAuth();

    const handleLogout = () => {
        logoutUser();
        navigate("/login");
    };

    return (
        <header className="dashboard-header">

            <style>
                {`
                    .dashboard-header {
                        position: sticky;
                        top: 0;
                        z-index: 50;
                        display: flex;
                        align-items: center;
                        justify-content: space-between;
                        gap: 1rem;
                        padding: 1rem 1.5rem;
                        background: rgba(5, 11, 26, 0.9);
                        backdrop-filter: blur(16px);
                        border-bottom: 1px solid rgba(255, 255, 255, 0.08);
                    }

                    .dashboard-header__logo-link {
                        display: flex;
                        align-items: center;
                        flex-shrink: 0;
                    }

                    .dashboard-header__logo {
                        height: 36px;
                        width: auto;
                        display: block;
                    }

                    .dashboard-header__logout {
                        flex-shrink: 0;
                        background: rgba(255, 255, 255, 0.05);
                        border: 1px solid rgba(255, 255, 255, 0.12);
                        color: #ffffff;
                        font-weight: 700;
                        font-size: 0.85rem;
                        padding: 0.55rem 1.1rem;
                        border-radius: 10px;
                        cursor: pointer;
                        transition: border-color 0.2s ease, background 0.2s ease;
                    }

                    .dashboard-header__logout:hover {
                        background: rgba(255, 255, 255, 0.1);
                        border-color: #00d4ff;
                    }

                    @media (max-width: 640px) {
                        .dashboard-header {
                            padding: 0.85rem 1rem;
                        }

                        .dashboard-header__logo {
                            height: 28px;
                        }
                    }
                `}
            </style>

            <Link to="/dashboard" className="dashboard-header__logo-link">
                <img
                    src={logo}
                    alt="Champions League Prono"
                    className="dashboard-header__logo"
                />
            </Link>

            <NavBar />

            <button onClick={handleLogout} className="dashboard-header__logout">
                Uitloggen
            </button>

        </header>
    );
}