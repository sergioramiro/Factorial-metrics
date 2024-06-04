import Index from "./components/Index";
import './App.css'
// import { useFetchUserData } from "./hooks/useFetchData";

export default function App() {
  // const {
  //   data,
  //   error,
  //   isLoading } = useFetchUserData();

  // if (isLoading) return <div>Loading...</div>;
  // if (error) return <div>Error: {error.message}</div>;

  return (
    <Index />
  );  
}
