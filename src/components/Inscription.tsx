import React from 'react';
import axios from "axios";
import logo from './logo.svg';
import { CharacterDetails, CharactersList } from '../styled/characterstyled';
import { Routes, Route, useNavigate } from 'react-router-dom';
const baseURL = "http://127.0.0.1:8087/professions/listofcharsthathavethatprofession";

export default function Characters() {
    const [post, setPost] = React.useState<any>();
    const navigate = useNavigate();

    React.useEffect(() => {
        axios.post(baseURL, {
            "ProfessionName": "Inscription"
        }).then((response) => {
            setPost(response.data);
        });
    }, []);

    if (!post) return null;
    return (
        <div>
            <div>
                {post?.map((character: any, index: any) => (
                    <div>
                        <p>{character.CharacterName}</p>
                    </div>))}
            </div>
        </div>
    );
}