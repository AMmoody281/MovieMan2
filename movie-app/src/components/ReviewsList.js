import React, {useEffect, useState} from 'react';
import axios from 'axios';

const ReviewsList = ({movieId}) => {
const [reviews,setReviews] = useState([]);

    useEffect(() =>{
        axios.get('http://localhost:8081/movies/${movieId}/reviews')
            .then(response => {
                setReviews(response.data);
            })
            .catch(error => {
                console.error('ERORR fetching reviews: ',error)
            })
    },[movieId]);

};