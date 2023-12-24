import React, {Component} from 'react';
import {GoogleMap, LoadScript, Marker} from '@react-google-maps/api';
import GooglePlacesAutocomplete from 'react-google-places-autocomplete';

class ApiExample extends Component {

    constructor() {
        super();
        this.state = {
            center: {
                lat: 0,
                lng: 0
            },
            containerStyle: {},
            zoom: 11,
            weatherData: {},
            picture: '',
            description: '',
            wind: '',
            temperature: ''
        }
    }

    componentDidMount() {

        if ("geolocation" in navigator) {
            console.log("Available");
            navigator.geolocation.getCurrentPosition((position) => {
                this.setState({
                    center: {
                        lat: position.coords.latitude,
                        lng: position.coords.longitude
                    }
                });
                fetch("https://api.openweathermap.org/data/2.5/weather?lat="
                    + position.coords.latitude + "&lon=" + position.coords.longitude +
                    "&appid=cdf05d929ed5cfa526764c43d2b832d2").then(response => response.json())
                    .then(data => {
                        this.setState({
                            picture: 'http://openweathermap.org/img/wn/' + data.weather[0].icon + '.png',
                            description: data.weather[0].description,
                            wind: data.wind.speed,
                            temperature: data.main.temp
                        })
                    })

            });

            this.setState({
                containerStyle: {
                    width: '400px',
                    height: '400px'
                },
            });
        } else {
            console.log("Not Available");
        }


    }

    changeLocation = () => {
        var name = document.getElementsByClassName(' css-1uccc91-singleValue')[0].innerText;
        console.log(name);
        var url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + name +
            "&key=AIzaSyBFItuGWneUe_7082cHZtJ8YxTtR8krmCw";
        console.log(url);
        fetch(url).then(response => response.json()).then(data => {
            this.setState({
                center: {
                    lat: data.results[0].geometry.location.lat,
                    lng: data.results[0].geometry.location.lng
                }
            });

            fetch("https://api.openweathermap.org/data/2.5/weather?lat="
                + data.results[0].geometry.location.lat + "&lon=" + data.results[0].geometry.location.lng +
                "&appid=cdf05d929ed5cfa526764c43d2b832d2").then(response => response.json())
                .then(data => {
                    this.setState({
                        picture: 'http://openweathermap.org/img/wn/' + data.weather[0].icon + '.png',
                        description: data.weather[0].description,
                        wind: data.wind.speed,
                        temperature: data.main.temp
                    })
                })
        })
    }

    render() {
        return (
            <div>
                <GooglePlacesAutocomplete
                    apiKey="AIzaSyBFItuGWneUe_7082cHZtJ8YxTtR8krmCw"
                />
                <LoadScript
                    googleMapsApiKey="AIzaSyBFItuGWneUe_7082cHZtJ8YxTtR8krmCw"
                >

                    <GoogleMap
                        mapContainerStyle={this.state.containerStyle}
                        center={this.state.center}
                        zoom={this.state.zoom}
                    >
                        <Marker
                            position={this.state.center}
                        />
                        { /* Child components, such as markers, info windows, etc. */}
                        <></>
                    </GoogleMap>
                </LoadScript>
                <table>
                    <tbody>
                    <tr>
                        <td colSpan="2"><img src={this.state.picture}/></td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>{this.state.description}</td>
                    </tr>
                    <tr>
                        <th>Wind</th>
                        <td>{this.state.wind}</td>
                    </tr>
                    <tr>
                        <th>Temperature</th>
                        <td>{this.state.temperature}</td>
                    </tr>
                    </tbody>
                </table>


                <button onClick={this.changeLocation}>Change Location</button>

            </div>
        );
    }
}

export default ApiExample;