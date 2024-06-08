import React from "react";
import useDeteleMetricById from "../hooks/useDeleteMetricById";

interface DeleteButtonProps {
  id: number;
}

const DeleteButton: React.FC<DeleteButtonProps> = ({ id }) => {
  const { deleteRecord } = useDeteleMetricById();

  const handleDelete = () => {
    deleteRecord(id);
  };

  return (
    <button
      onClick={() => handleDelete()}
      className="bg-factorial hover:bg-factorial-500 text-white font-bold py-2 px-4 rounded flex items-center"
    >
      <img src="/trash-svgrepo-com.svg" alt="Eliminar" className="h-4 w-4 " />
    </button>
  );
};

export default DeleteButton;
