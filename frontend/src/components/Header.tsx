import React from "react";

const Header: React.FC = () => {
  return (
    <header className="flex justify-between items-center py-4">
      <img src="/factorial_icon.png" alt="Logo" className="h-8 w-8 ml-4" />
      <button className="bg-orange-500 hover:bg-orange-700 text-white font-bold py-2 px-4 rounded">
        Añadir
      </button>
    </header>
  );
};

export default Header;
