//ProtectedRoute.tsx

import { Navigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";

interface Props {
    children: React.ReactNode;
}

export default function ProtectedRoute({
                                           children
                                       }: Props) {

    const { user, loading } = useAuth();


    if (loading) {
        return (
            <div className="
                min-h-screen
                flex
                items-center
                justify-center
                bg-gray-950
                text-white
            ">
                Laden...
            </div>
        );
    }


    if (!user) {
        return (
            <Navigate
                to="/login"
                replace
            />
        );
    }


    return children;
}