// AuthContextValue.ts

import { createContext } from "react";

import type {
    CurrentUserResponse,
    LoginRequest,
    RegisterRequest
} from "../types/auth";


export interface AuthContextType {

    user: CurrentUserResponse | null;

    loading: boolean;

    loginUser(
        request: LoginRequest
    ): Promise<void>;


    registerUser(
        request: RegisterRequest
    ): Promise<void>;


    logoutUser(): void;

}


export const AuthContext =
    createContext<AuthContextType | undefined>(
        undefined
    );