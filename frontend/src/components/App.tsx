import React from "react";
import Chart from "./Chart";
import Header from "./Header";
import TableMetrics from "./TableMetrics";
import CreateMetric from "./CreateMetric";
import { useGetAllNames } from "../hooks/useAllNames";

const App: React.FC = () => {
  const { data, error, isLoading } = useGetAllNames();

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;
  return (
    <div>
      <Header />
      <Chart names={data} />
      <CreateMetric />
      <TableMetrics />
    </div>
  );
};

export default App;
