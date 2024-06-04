import React from "react";

const TableMetrics: React.FC = () => {
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
