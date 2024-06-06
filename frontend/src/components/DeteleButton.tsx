import React from "react";

const DeleteButton: React.FC = () => {
  return (
    <button
      //onClick={() => handleDelete(item.id)}
      className="bg-factorial hover:bg-factorial-500 text-white font-bold py-2 px-4 rounded flex items-center"
    >
      <img src="/trash-svgrepo-com.svg" alt="Eliminar" className="h-4 w-4 " />
    </button>
  );
};

export default DeleteButton;
