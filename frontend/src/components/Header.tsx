import React from "react";

const Header: React.FC = () => {
  return (
    <header className="flex justify-between items-center py-4">
      <img src="/factorial.png" alt="Factorial" className="h-8 w-8 ml-4" />
      <button className="bg-factorial hover:bg-factorial-500 text-white font-bold py-2 px-4 rounded">
        Añadir
      </button>
    </header>
  );
};

export default Header;
