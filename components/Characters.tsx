import React from 'react';
import axios from "axios";
import logo from './logo.svg';
import { CharacterDetails, CharactersList } from '../styled/characterstyled';
const baseURL = "http://127.0.0.1:8087/characters/listofcharacters";

export default function Characters() {
    const [post, setPost] = React.useState<any>();
    React.useEffect(() => {
        axios.get(baseURL).then((response) => {
            setPost(response.data);
        });
    }, []);

    if (!post) return null;
    return (
        
        <div>
            {post?.map((character: any, index: any) => (
                <CharactersList>
                    <CharacterDetails>
                        <p>Character Name:{character.CharacterName}</p>
                        <p>Caracter Armor type:{character.ArmorType}</p>
                        </CharacterDetails>
                </CharactersList>
            ))}
        </div>
    );
}