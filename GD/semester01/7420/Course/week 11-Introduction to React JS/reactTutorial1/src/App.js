import logo from './logo.svg';
import './App.css';
import Hello from "./components/Hello";
import Hello2 from "./components/Hello2";
import MyClass from "./components/MyClass";
import Name from "./components/Name";
import Maps from "./components/Maps";
import Form from "./components/Form";
import ApiExample from "./components/APIExample";
import Jsonplaceholder from "./components/Jsonplaceholder";

function App() {

    // function classClicked(){
    //     alert('Inside App.js for class component click')
    // }

    return (
        <div className="container">
            {/*<Hello firstname={"Lei"} lastname={"Song"}/>*/}
            {/*<MyClass firstname={"Lei"} lastname={"Song"} myclick={classClicked}/>*/}
            {/*<Name />*/}
            {/*<Maps names = {['React', 'Java', 'Python', 'C#']} />*/}
            {/*<Form />*/}
            {/*<ApiExample/>*/}
            <Jsonplaceholder />
        </div>
    );
}

export default App;
