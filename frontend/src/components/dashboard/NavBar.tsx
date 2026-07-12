// components/dashboard/NavBar.tsx
import { useEffect, useRef, useState } from "react";
import { NavLink } from "react-router-dom";

const mainLinks = [
    { to: "/dashboard", label: "Dashboard" },
    { to: "/mijn-team", label: "Mijn team" },
    { to: "/ranglijst", label: "Ranglijst" },
    { to: "/teams", label: "Teams" },
];

const moreLinks = [
    { to: "/prijzen", label: "Prijzen" },
    { to: "/regels", label: "Regels & info" },
];

export default function NavBar() {

    const [moreOpen, setMoreOpen] = useState(false);
    const [mobileOpen, setMobileOpen] = useState(false);
    const moreRef = useRef<HTMLDivElement>(null);

    useEffect(() => {

        const handleClickOutside = (event: MouseEvent) => {
            if (moreRef.current && !moreRef.current.contains(event.target as Node)) {
                setMoreOpen(false);
            }
        };

        document.addEventListener("mousedown", handleClickOutside);
        return () => document.removeEventListener("mousedown", handleClickOutside);

    }, []);

    const linkClass = ({ isActive }: { isActive: boolean }) =>
        isActive ? "navbar__link navbar__link--active" : "navbar__link";

    return (
        <nav className="navbar">

            <style>
                {`
                    .navbar {
                        flex: 1;
                        display: flex;
                        justify-content: center;
                    }

                    .navbar__desktop {
                        display: flex;
                        align-items: center;
                        gap: 0.5rem;
                    }

                    .navbar__link {
                        color: rgba(255, 255, 255, 0.65);
                        text-decoration: none;
                        font-size: 0.9rem;
                        font-weight: 600;
                        padding: 0.5rem 0.9rem;
                        border-radius: 8px;
                        transition: color 0.2s ease, background 0.2s ease;
                        white-space: nowrap;
                    }

                    .navbar__link:hover {
                        color: #ffffff;
                        background: rgba(255, 255, 255, 0.06);
                    }

                    .navbar__link--active {
                        color: #ffffff;
                        background: rgba(0, 212, 255, 0.12);
                    }

                    .navbar__more {
                        position: relative;
                    }

                    .navbar__more-btn {
                        display: inline-flex;
                        align-items: center;
                        gap: 0.35rem;
                        background: none;
                        border: none;
                        color: rgba(255, 255, 255, 0.65);
                        font-size: 0.9rem;
                        font-weight: 600;
                        padding: 0.5rem 0.9rem;
                        border-radius: 8px;
                        cursor: pointer;
                        transition: color 0.2s ease, background 0.2s ease;
                    }

                    .navbar__more-btn:hover {
                        color: #ffffff;
                        background: rgba(255, 255, 255, 0.06);
                    }

                    .navbar__more-panel {
                        position: absolute;
                        top: calc(100% + 0.5rem);
                        right: 0;
                        min-width: 180px;
                        background: rgba(10, 18, 36, 0.97);
                        border: 1px solid rgba(255, 255, 255, 0.1);
                        border-radius: 12px;
                        padding: 0.5rem;
                        box-shadow: 0 20px 45px rgba(0, 0, 0, 0.5);
                        display: flex;
                        flex-direction: column;
                        gap: 0.15rem;
                        z-index: 60;
                    }

                    .navbar__mobile {
                        display: none;
                    }

                    .navbar__mobile-btn {
                        background: rgba(255, 255, 255, 0.05);
                        border: 1px solid rgba(255, 255, 255, 0.12);
                        color: #ffffff;
                        width: 40px;
                        height: 40px;
                        border-radius: 10px;
                        font-size: 1.1rem;
                        cursor: pointer;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                    }

                    .navbar__mobile-panel {
                        position: absolute;
                        top: calc(100% + 0.75rem);
                        left: -1rem;
                        right: -1rem;
                        background: rgba(10, 18, 36, 0.98);
                        border-bottom: 1px solid rgba(255, 255, 255, 0.1);
                        padding: 0.75rem 1rem 1.25rem;
                        display: flex;
                        flex-direction: column;
                        gap: 0.25rem;
                        z-index: 60;
                    }

                    .navbar__mobile-divider {
                        height: 1px;
                        background: rgba(255, 255, 255, 0.1);
                        margin: 0.5rem 0;
                    }

                    @media (max-width: 768px) {
                        .navbar {
                            justify-content: flex-end;
                            position: relative;
                        }

                        .navbar__desktop {
                            display: none;
                        }

                        .navbar__mobile {
                            display: block;
                            position: relative;
                        }
                    }
                `}
            </style>

            <div className="navbar__desktop">

                {mainLinks.map((link) => (
                    <NavLink key={link.to} to={link.to} className={linkClass}>
                        {link.label}
                    </NavLink>
                ))}

                <div className="navbar__more" ref={moreRef}>

                    <button
                        type="button"
                        className="navbar__more-btn"
                        onClick={() => setMoreOpen((open) => !open)}
                    >
                        Meer ▾
                    </button>

                    {moreOpen && (
                        <div className="navbar__more-panel">
                            {moreLinks.map((link) => (
                                <NavLink
                                    key={link.to}
                                    to={link.to}
                                    className={linkClass}
                                    onClick={() => setMoreOpen(false)}
                                >
                                    {link.label}
                                </NavLink>
                            ))}
                        </div>
                    )}

                </div>

            </div>

            <div className="navbar__mobile">

                <button
                    type="button"
                    className="navbar__mobile-btn"
                    onClick={() => setMobileOpen((open) => !open)}
                    aria-label="Menu"
                >
                    ☰
                </button>

                {mobileOpen && (
                    <div className="navbar__mobile-panel">

                        {mainLinks.map((link) => (
                            <NavLink
                                key={link.to}
                                to={link.to}
                                className={linkClass}
                                onClick={() => setMobileOpen(false)}
                            >
                                {link.label}
                            </NavLink>
                        ))}

                        <div className="navbar__mobile-divider" />

                        {moreLinks.map((link) => (
                            <NavLink
                                key={link.to}
                                to={link.to}
                                className={linkClass}
                                onClick={() => setMobileOpen(false)}
                            >
                                {link.label}
                            </NavLink>
                        ))}

                    </div>
                )}

            </div>

        </nav>
    );
}