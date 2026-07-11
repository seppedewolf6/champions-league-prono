// authApi.ts

import api from "./axios";
import type {
    AuthResponse,
    CurrentUserResponse,
    LoginRequest,
    RegisterRequest,
} from "../types/auth";

/**
 * Registreert een nieuwe gebruiker.
 */
export const register = async (
    request: RegisterRequest
): Promise<AuthResponse> => {
    const response = await api.post<AuthResponse>(
        "/auth/register",
        request
    );

    return response.data;
};

/**
 * Logt een gebruiker in.
 */
export const login = async (
    request: LoginRequest
): Promise<AuthResponse> => {
    const response = await api.post<AuthResponse>(
        "/auth/login",
        request
    );

    return response.data;
};

/**
 * Haalt de momenteel ingelogde gebruiker op.
 */
export const getCurrentUser =
    async (): Promise<CurrentUserResponse> => {
        const response =
            await api.get<CurrentUserResponse>(
                "/auth/me"
            );

        return response.data;
    };