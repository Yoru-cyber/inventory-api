import { Home, Settings, Pill, ShoppingCart, CreditCard } from 'lucide-react';
import { NavLink } from 'react-router';

const Navbar = () => {
    return (
        <nav className="bg-white shadow-lg">
            <div className="max-w-7xl mx-auto px-4">
                <div className="flex justify-between h-16">
                    <div className="flex space-x-8">
                        <NavLink
                            to="/"
                            className={({ isActive }) =>
                                `inline-flex items-center px-3 py-2 text-sm font-medium ${isActive
                                    ? 'text-blue-600 border-b-2 border-blue-600'
                                    : 'text-gray-500 hover:text-blue-600 hover:border-b-2 hover:border-blue-300'
                                }`
                            }
                        >
                            <Home className="w-4 h-4 mr-2" />
                            Home
                        </NavLink>
                        <NavLink
                            to="/medicine"
                            className={({ isActive }) =>
                                `inline-flex items-center px-3 py-2 text-sm font-medium ${isActive
                                    ? 'text-blue-600 border-b-2 border-blue-600'
                                    : 'text-gray-500 hover:text-blue-600 hover:border-b-2 hover:border-blue-300'
                                }`
                            }
                        >
                            <Pill className="w-4 h-4 mr-2" />
                            Medicine
                        </NavLink>
                        <NavLink
                            to="/sale"
                            className={({ isActive }) =>
                                `inline-flex items-center px-3 py-2 text-sm font-medium ${isActive
                                    ? 'text-blue-600 border-b-2 border-blue-600'
                                    : 'text-gray-500 hover:text-blue-600 hover:border-b-2 hover:border-blue-300'
                                }`
                            }
                        >
                            <CreditCard className="w-4 h-4 mr-2" />
                            Sale
                        </NavLink>
                        <NavLink
                            to="/purchase"
                            className={({ isActive }) =>
                                `inline-flex items-center px-3 py-2 text-sm font-medium ${isActive
                                    ? 'text-blue-600 border-b-2 border-blue-600'
                                    : 'text-gray-500 hover:text-blue-600 hover:border-b-2 hover:border-blue-300'
                                }`
                            }
                        >
                            <ShoppingCart className="w-4 h-4 mr-2" />
                            Purchase
                        </NavLink>
                        <NavLink
                            to="/providers"
                            className={({ isActive }) =>
                                `inline-flex items-center px-3 py-2 text-sm font-medium ${isActive
                                    ? 'text-blue-600 border-b-2 border-blue-600'
                                    : 'text-gray-500 hover:text-blue-600 hover:border-b-2 hover:border-blue-300'
                                }`
                            }
                        >
                            <Settings className="w-4 h-4 mr-2" />
                            Providers
                        </NavLink>
                    </div>
                </div>
            </div>
        </nav>
    );
};

export default Navbar;