import React from "react";
// import { useFetchData2 } from "../hooks/useFetchData2";

const TableMetrics: React.FC = () => {
//   const { data, error, isLoading } = useFetchData2();
//   if (isLoading) return <div>Loading...</div>;
//   if (error) return <div>Error: {error.message}</div>;
//   console.log(data);

  return (
    <table className="w-full mb-4">
      <thead>
        <tr className="bg-gray-200">
          <th className="px-4 py-2">ID</th>
          <th className="px-4 py-2">Nombre</th>
          <th className="px-4 py-2">Valor</th>
          <th className="px-4 py-2">Timestamp</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td className="px-4 py-2">1</td>
          <td className="px-4 py-2">Elemento 1</td>
          <td className="px-4 py-2">10</td>
          <td className="px-4 py-2">2022-01-01 12:00:00</td>
        </tr>
        <tr>
          <td className="px-4 py-2">2</td>
          <td className="px-4 py-2">Elemento 2</td>
          <td className="px-4 py-2">20</td>
          <td className="px-4 py-2">2022-01-01 12:05:00</td>
        </tr>
      </tbody>
    </table>
  );
};

export default TableMetrics;
