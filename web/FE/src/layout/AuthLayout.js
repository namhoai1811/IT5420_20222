import { Outlet, Navigate } from "react-router-dom";
import { storage } from "../service/storage";

export const AuthLayout = () => {
    const isAuthentication = !!storage.getItem("token");
    if (!isAuthentication) {
        return <Outlet />;
    }
    return <Navigate to="/home"></Navigate>;
};
