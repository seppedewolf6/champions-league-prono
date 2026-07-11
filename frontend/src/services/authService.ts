//authService.ts
import {
    login as loginApi,
    register as registerApi,
    getCurrentUser
} from "../api/authApi";

import type {
    LoginRequest,
    RegisterRequest,
    CurrentUserResponse
} from "../types/auth";


const TOKEN_KEY = "token";


/**
 * Registreert een nieuwe gebruiker
 */
export const register = async (
    request: RegisterRequest
) => {

    const response = await registerApi(request);

    saveToken(response.token);

    return response;
};


/**
 * Logt een bestaande gebruiker in
 */
export const login = async (
    request: LoginRequest
) => {

    const response = await loginApi(request);

    saveToken(response.token);

    return response;
};


/**
 * Haalt de huidige gebruiker op
 */
export const fetchCurrentUser =
    async (): Promise<CurrentUserResponse> => {

        const response =
            await getCurrentUser();

        return response;
    };


/**
 * Bewaart JWT token
 */
export const saveToken = (
    token: string
) => {

    localStorage.setItem(
        TOKEN_KEY,
        token
    );
};


/**
 * Geeft JWT token terug
 */
export const getToken = () => {

    return localStorage.getItem(
        TOKEN_KEY
    );
};


/**
 * Controleert of gebruiker ingelogd is
 */
export const isAuthenticated = () => {

    return !!getToken();

};


/**
 * Logt gebruiker uit
 */
export const logout = () => {

    localStorage.removeItem(
        TOKEN_KEY
    );

};