import React from "react";
import Chart from "./Chart";
import Header from "./Header";
import TableMetrics from "./TableMetrics";
import CreateMetric from "./CreateMetric";
import { useFetchUserData } from "../hooks/useFetchData";

const Index: React.FC = () => {
  const { data, error, isLoading } = useFetchUserData();

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;
  console.log(data);
  return (
    <div>
      <Header />
      <Chart data={data} />
      <CreateMetric />
      <TableMetrics />
    </div>
  );
};

export default Index;
