//LoginPage.tsx
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


const loginSchema = z.object({
    email: z
        .string()
        .email("Geef een geldig emailadres"),

    password: z
        .string()
        .min(1, "Wachtwoord is verplicht")
});


type LoginFormData = z.infer<typeof loginSchema>;


export default function LoginPage() {

    const navigate = useNavigate();

    const {loginUser} = useAuth();


    const [serverError, setServerError] =
        useState<string | null>(null);


    const {
        register,
        handleSubmit,
        formState: {
            errors,
            isSubmitting
        }

    } = useForm<LoginFormData>({
        resolver: zodResolver(loginSchema)
    });


    const onSubmit = async (
        data: LoginFormData
    ) => {

        try {

            setServerError(null);


            await loginUser(data);


            navigate("/dashboard");


        } catch (error) {

            setServerError(
                getApiErrorMessage(
                    error,
                    "Email of wachtwoord is fout."
                )
            );

        }

    };


    return (

        <AuthCard
            title="Welkom terug"
            subtitle="Log in en beheer jouw Champions League ploeg"
        >

            <form
                onSubmit={handleSubmit(onSubmit)}
            >


                <AuthInput
                    label="Email"
                    type="email"
                    placeholder="email@test.be"
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
                    type="password"
                    placeholder="********"
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
                    Inloggen
                </AuthButton>


                <p className="auth-switch">
                    Nog geen account?
                    <button
                        type="button"
                        onClick={() => navigate("/")}
                        className="auth-switch__link"
                    >
                        Registreren
                    </button>
                </p>


            </form>


        </AuthCard>

    );

}