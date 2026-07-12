// components/common/PlaceholderPage.tsx
interface Props {
    title: string;
}

export default function PlaceholderPage({ title }: Props) {
    return (
        <div className="placeholder-page">

            <style>
                {`
                    .placeholder-page {
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: center;
                        padding: 4rem 1.5rem;
                        text-align: center;
                        color: rgba(255, 255, 255, 0.6);
                    }

                    .placeholder-page__title {
                        color: #ffffff;
                        font-size: 1.6rem;
                        font-weight: 800;
                        margin-bottom: 0.75rem;
                    }
                `}
            </style>

            <h1 className="placeholder-page__title">{title}</h1>
            <p>Deze pagina is binnenkort beschikbaar.</p>

        </div>
    );
}