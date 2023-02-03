import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ArtworkList extends Component {

    constructor(props) {
        super(props);
        this.state = {artworks: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/artworks')
            .then(response => response.json())
            .then(data => this.setState({artworks: data}));
    }

    async remove(id) {
        await fetch(`/artworks/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedartworks = [...this.state.artworks].filter(i => i.id !== id);
            this.setState({artworks: updatedartworks});
        });
    }
    
    render() {
        const {artworks, isLoading} = this.state;
    
        if (isLoading) {
            return <p>Loading...</p>;
        }
    
        const artworkList = artworks.map(artwork => {
            return <tr key={artwork.id}>
                <td style={{whiteSpace: 'nowrap'}}>{artwork.title}</td>
                <td>{artwork.author}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/artworks/" + artwork.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(artwork.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });
    
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/artworks/new">Add artwork</Button>
                    </div>
                    <h3>artworks</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Title</th>
                            <th width="30%">Author</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {artworkList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default ArtworkList;