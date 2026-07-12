// layout/DashboardLayout.tsx
import { Outlet } from "react-router-dom";
import DashboardHeader from "../components/dashboard/DashboardHeader";

export default function DashboardLayout() {
    return (
        <div className="dashboard-shell">

            <style>
                {`
                    .dashboard-shell {
                        min-height: 100dvh;
                        width: 100%;
                        background-color: #050b1a;
                        background-image:
                            radial-gradient(circle at 15% 0%, rgba(0, 212, 255, 0.08), transparent 45%),
                            radial-gradient(circle at 85% 20%, rgba(192, 38, 211, 0.08), transparent 45%);
                        display: flex;
                        flex-direction: column;
                    }

                    .dashboard-shell__content {
                        flex: 1;
                        width: 100%;
                        max-width: 1100px;
                        margin: 0 auto;
                        padding: 1.5rem;
                    }

                    @media (max-width: 640px) {
                        .dashboard-shell__content {
                            padding: 1rem;
                        }
                    }
                `}
            </style>

            <DashboardHeader />

            <main className="dashboard-shell__content">
                <Outlet />
            </main>

        </div>
    );
}