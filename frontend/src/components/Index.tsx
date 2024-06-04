import React from "react";
import Chart from "./Chart";
import Header from "./Header";
import TableMetrics from "./TableMetrics";

const Index: React.FC = () => {
  return (
    <div>
      <Header />
      <Chart />
      <TableMetrics />
    </div>
  );
};

export default Index;
