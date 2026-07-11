// RegisterPage.tsx
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {useForm} from "react-hook-form";
import {z} from "zod";
import {zodResolver} from "@hookform/resolvers/zod";

import AuthCard from "../components/auth/AuthCard";
import AuthInput from "../components/auth/AuthInput";
import AuthButton from "../components/auth/AuthButton";

import {useAuth} from "../hooks/useAuth";
import {getApiErrorMessage} from "../utils/apiError";


const registerSchema = z.object({
    username: z
        .string()
        .min(3, "Gebruikersnaam moet minstens 3 tekens bevatten"),

    email: z
        .string()
        .email("Geef een geldig emailadres"),

    password: z
        .string()
        .min(8, "Wachtwoord moet minstens 8 tekens bevatten")
});


type RegisterFormData = z.infer<typeof registerSchema>;


export default function RegisterPage() {

    const navigate = useNavigate();

    const {registerUser} = useAuth();


    const [serverError, setServerError] =
        useState<string | null>(null);


    const {
        register,
        handleSubmit,
        formState: {
            errors,
            isSubmitting
        }
    } = useForm<RegisterFormData>({
        resolver: zodResolver(registerSchema)
    });


    const onSubmit = async (
        data: RegisterFormData
    ) => {

        try {

            setServerError(null);

            await registerUser(data);

            navigate("/dashboard");

        } catch (error) {

            setServerError(
                getApiErrorMessage(
                    error,
                    "Registreren mislukt. Controleer je gegevens."
                )
            );

        }

    };


    return (
        <AuthCard
            title="Maak jouw droomteam"
            subtitle="Word manager van jouw eigen Champions League ploeg"
        >

            <form
                onSubmit={handleSubmit(onSubmit)}
            >


                <AuthInput
                    label="Gebruikersnaam"
                    placeholder="bv. Seppe"
                    {...register("username")}
                />


                {
                    errors.username && (
                        <p className="text-red-400 text-sm mb-3">
                            {errors.username.message}
                        </p>
                    )
                }


                <AuthInput
                    label="Email"
                    placeholder="email@test.be"
                    type="email"
                    {...register("email")}
                />


                {
                    errors.email && (
                        <p className="text-red-400 text-sm mb-3">
                            {errors.email.message}
                        </p>
                    )
                }


                <AuthInput
                    label="Wachtwoord"
                    placeholder="********"
                    type="password"
                    {...register("password")}
                />

                {
                    errors.password && (
                        <p className="text-red-400 text-sm mb-3">
                            {errors.password.message}
                        </p>
                    )
                }


                {
                    serverError && (

                        <p className="text-red-400 text-sm mb-4">
                            {serverError}
                        </p>

                    )
                }


                <AuthButton loading={isSubmitting}>
                    Account maken
                </AuthButton>


                <p className="auth-switch">
                    Heb je al een account?
                    <button
                        type="button"
                        onClick={() => navigate("/login")}
                        className="auth-switch__link"
                    >
                        Login
                    </button>
                </p>

            </form>

        </AuthCard>
    );
}