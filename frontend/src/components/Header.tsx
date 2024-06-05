import React from "react";

const Header: React.FC = () => {
  return (
    <header className="flex justify-between items-center py-4">
      <img src="/factorial.png" alt="Factorial" className="max-h-16 max-w-36" />
    </header>
  );
};

export default Header;
