//auth.ts
export interface RegisterRequest {
    username: string;
    email: string;
    password: string;
}

export interface LoginRequest {
    email: string;
    password: string;
}

export interface AuthResponse {
    token: string;
}

export interface CurrentUserResponse {
    id: string;
    username: string;
    email: string;
    role: string;
}