import React from 'react';
import axios from "axios";
import logo from './logo.svg';
import './App.css';
import Characters from './components/Characters';
import Professions from './components/Professions'
import Blacksmithing from './components/Blacksmithing'
import Alchemy from './components/Alchemy'
import Herbalism from './components/Herbalism'
import { Routes, Route, useNavigate } from 'react-router-dom';
const baseURL = "http://127.0.0.1:8087/professions/listofprofessions";

export default function App() {

    const navigate = useNavigate();

    const navigateToCharacters = () => {

        navigate('/characters');
    };
    const navigateToProfessions = () => {

        navigate('/professions');
    };

    const navigateHome = () => {
        navigate('/');
    };

    return (
        <div>
            <div>
                <button onClick={navigateToCharacters}>Charachters</button>
                <button onClick={navigateToProfessions}>Professions</button>

                <Routes>
                    <Route path="/characters" element={<RenderCharacters />} />
                    <Route path="/professions" element={<RenderProfessions />} />
                    <Route path="/Blacksmithing" element={<RenderBlacksmithing />} />
                    <Route path="/Alchemy" element={<RenderAlchemy />} />
                    <Route path="/Herbalism" element={<RenderHerbalism />} />
                </Routes>
            </div>
        </div>
    );
}

function RenderCharacters() {
    return <Characters/>
}
function RenderProfessions() {
    return <Professions />
}
function RenderBlacksmithing() {
    return <Blacksmithing/>
}
function RenderAlchemy() {
    return <Alchemy />
}
function RenderHerbalism() {
    return <Herbalism />
}