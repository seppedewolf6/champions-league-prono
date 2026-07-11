//AuthContext.tsx

import {
    useEffect,
    useState
} from "react";

import {AuthContext} from "./AuthContextValue";

import type {
    CurrentUserResponse,
    LoginRequest,
    RegisterRequest
} from "../types/auth";

import {
    login,
    register,
    logout,
    fetchCurrentUser,
    isAuthenticated
} from "../services/authService";


export function AuthProvider({
                                 children
                             }: {
    children: React.ReactNode
}) {


    const [user, setUser] =
        useState<CurrentUserResponse | null>(
            null
        );


    const [loading, setLoading] =
        useState(true);


    useEffect(() => {

        const loadUser = async () => {

            if (!isAuthenticated()) {
                setLoading(false);
                return;
            }

            try {
                const currentUser = await fetchCurrentUser();
                setUser(currentUser);
            } catch {
                logout();
            } finally {
                setLoading(false);
            }

        };

        loadUser();

    }, []);


    const loginUser = async (
        request: LoginRequest
    ) => {

        await login(request);

        const currentUser =
            await fetchCurrentUser();


        setUser(currentUser);

    };


    const registerUser = async (
        request: RegisterRequest
    ) => {


        await register(request);


        const currentUser =
            await fetchCurrentUser();


        setUser(currentUser);

    };


    const logoutUser = () => {

        logout();

        setUser(null);

    };


    return (

        <AuthContext.Provider

            value={{

                user,

                loading,

                loginUser,

                registerUser,

                logoutUser

            }}

        >

            {children}


        </AuthContext.Provider>

    );
}