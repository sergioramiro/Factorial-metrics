import React from "react";
import { useFetchMetrics } from "../hooks/useFetchMetrics";
import DeleteButton from "./DeteleButton";

interface Metric {
  id: number;
  timestamp: string;
  name: string;
  value: number;
}

const TableMetrics: React.FC = () => {
  const { data, error, isLoading } = useFetchMetrics();

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  return (
    <div className="max-h-96 overflow-y-auto rounded-md">
      <table className="w-full mb-4">
        <thead>
          <tr className="bg-gray-200">
            <th className="px-4 py-2">ID</th>
            <th className="px-4 py-2">Nombre</th>
            <th className="px-4 py-2">Valor</th>
            <th className="px-4 py-2">Timestamp</th>
            <th className="px-4 py-2"></th>
          </tr>
        </thead>
        <tbody>
          {data.map((item: Metric, index: number) => (
            <tr key={item.id} className={index % 2 === 0 ? "bg-gray-100" : ""}>
              <td className="px-4 py-2">{item.id}</td>
              <td className="px-4 py-2">{item.name}</td>
              <td className="px-4 py-2">{item.value}</td>
              <td className="px-4 py-2">{item.timestamp}</td>
              <td className="px-4 py-2">
                <DeleteButton />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TableMetrics;
