// src/utils/apiError.ts
import axios from "axios";
import type { ApiError } from "../types/auth";

export function getApiErrorMessage(
    error: unknown,
    fallback: string
): string {

    if (axios.isAxiosError<ApiError>(error)) {
        return error.response?.data?.message ?? fallback;
    }

    return fallback;
}