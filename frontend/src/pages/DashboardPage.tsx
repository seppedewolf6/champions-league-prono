// DashboardPage.tsx
import {useAuth} from "../hooks/useAuth";

export default function DashboardPage(){

    const {user} = useAuth();

    return (

        <div className="
            min-h-screen
            bg-gray-950
            text-white
            flex
            items-center
            justify-center
        ">

            <h1 className="text-3xl font-bold">

                Welkom {user?.username}

            </h1>

        </div>

    );

}