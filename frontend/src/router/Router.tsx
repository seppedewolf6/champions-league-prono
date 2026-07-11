// Router.tsx
import {
    BrowserRouter,
    Routes,
    Route
} from "react-router-dom";

import AuthLayout from "../layout/AuthLayout";

import RegisterPage from "../pages/RegisterPage";
import LoginPage from "../pages/LoginPage";
import DashboardPage from "../pages/DashboardPage";


export default function Router(){

    return (

        <BrowserRouter>

            <Routes>

                <Route element={<AuthLayout />}>

                    <Route
                        path="/"
                        element={<RegisterPage />}
                    />

                    <Route
                        path="/login"
                        element={<LoginPage />}
                    />

                </Route>


                <Route
                    path="/dashboard"
                    element={<DashboardPage />}
                />

            </Routes>

        </BrowserRouter>

    );

}