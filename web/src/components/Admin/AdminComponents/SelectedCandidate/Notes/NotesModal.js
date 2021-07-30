import React, {useState} from 'react';
import classes from './NotesModal.css';
import Modal from 'react-bootstrap/Modal'

function NotesModal() {
    const [show, setShow] = useState(false);
  
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
  
    return (
      <React.Fragment>
        <button variant="primary" onClick={handleShow}>
          Add Notes
        </button>
  
        <Modal show={show} onHide={handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Notes</Modal.Title>
          </Modal.Header>
          <Modal.Body>
              <form><textarea className={classes.textarea}></textarea>
              </form>
          </Modal.Body>
          <Modal.Footer>
            <button variant="secondary" onClick={handleClose}>
              Close
            </button>
            <button variant="primary" onClick={handleClose}>
              Save Note
            </button>
          </Modal.Footer>
        </Modal>
      </React.Fragment>
    );
  }
  
export default NotesModal;
