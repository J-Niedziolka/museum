import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class ArtworkEdit extends Component {
    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const artwork = await (await fetch(`/artworks/${this.props.match.params.id}`)).json();
            this.setState({item: artwork});
        }
    }

    emptyItem = {
        id: '',
        title: '',
        type: '',
        author: '',
        date: '',
        ifRenovation: '',
        ifExhibition: '',
        history: '',
        details: '',
        ifExhibition: '',
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;
    
        await fetch('/artworks' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/artworks');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Artwork' : 'Add Artwork'}</h2>;
    
        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="title">Title</Label>
                        <Input type="text" name="title" id="title" value={item.title || ''}
                               onChange={this.handleChange} autoComplete="title"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="author">author</Label>
                        <Input type="text" name="author" id="author" value={item.author || ''}
                               onChange={this.handleChange} autoComplete="author"/>
                    </FormGroup>
                    {/* <FormGroup>
                        <Label for=""></Label>
                        <Input type="" name="" id="" value={item. || ''}
                               onChange={this.handleChange} autoComplete=""/>
                    </FormGroup> */}
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/artworks">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default withRouter(ArtworkEdit);