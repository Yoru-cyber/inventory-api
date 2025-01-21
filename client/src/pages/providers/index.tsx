import { useQuery } from "react-query"
import Provider from "../../ts/interfaces/provider.interface";


const fetchProviders = async (): Promise<Provider[]> => {
    const response = await fetch('http://localhost:8080/api/v1/providers/');
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    return response.json();
};
function ProvidersIndex() {

    const { isPending, error, data } = useQuery<Provider[]>({
        queryKey: ['providers'],
        queryFn: fetchProviders,
    });

    if (isPending) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error.message}</div>;
    }

    return (
        <div>
            <h1>Providers</h1>
            <ul>
                {data?.map((provider) => (
                    <li key={provider.id}>
                        <h2>{provider.name}</h2>
                        <p>ID: {provider.id}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
}
export default ProvidersIndex;