// Router.tsx
import {
    BrowserRouter,
    Routes,
    Route
} from "react-router-dom";

import AuthLayout from "../layout/AuthLayout";
import DashboardLayout from "../layout/DashboardLayout";
import ProtectedRoute from "../components/auth/ProtectedRoute";

import RegisterPage from "../pages/RegisterPage";
import LoginPage from "../pages/LoginPage";
import DashboardPage from "../pages/DashboardPage";
import MijnTeamPage from "../pages/MijnTeamPage";
import RanglijstPage from "../pages/RanglijstPage";
import TeamsPage from "../pages/TeamsPage";
import PrijzenPage from "../pages/PrijzenPage";
import RegelsPage from "../pages/RegelsPage";


export default function Router(){

    return (

        <BrowserRouter>

            <Routes>

                <Route element={<AuthLayout />}>
                    <Route path="/" element={<RegisterPage />} />
                    <Route path="/login" element={<LoginPage />} />
                </Route>

                <Route
                    element={
                        <ProtectedRoute>
                            <DashboardLayout />
                        </ProtectedRoute>
                    }
                >
                    <Route path="/dashboard" element={<DashboardPage />} />
                    <Route path="/mijn-team" element={<MijnTeamPage />} />
                    <Route path="/ranglijst" element={<RanglijstPage />} />
                    <Route path="/teams" element={<TeamsPage />} />
                    <Route path="/prijzen" element={<PrijzenPage />} />
                    <Route path="/regels" element={<RegelsPage />} />
                </Route>

            </Routes>

        </BrowserRouter>

    );

}