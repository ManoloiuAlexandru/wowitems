import React from 'react';
import axios from "axios";
import logo from './logo.svg';
import { CharacterDetails, CharactersList } from '../styled/characterstyled';
import { Routes, Route, useNavigate } from 'react-router-dom';
const baseURL = "http://127.0.0.1:8087/professions/listofprofessionsnames";

export default function Characters() {
    const [post, setPost] = React.useState<any>();
    const navigate = useNavigate();

    const navigateToProfession = (props:any) => {
        navigate('/' + props);
    };
    React.useEffect(() => {
        axios.get(baseURL).then((response) => {
            setPost(response.data);
        });
    }, []);

    if (!post) return null;
    return (

        <div>
            {
                post?.map((profession: any, index: any) => (
                <CharactersList>
                        <CharacterDetails>
                            <button onClick={() => { navigateToProfession(profession) }}>Profession Name:{profession}</button>
                    </CharacterDetails>
                </CharactersList>
                ))}
        </div>
    );
}